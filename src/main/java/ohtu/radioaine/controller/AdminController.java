/*
 * :
 *  - admin: directs caller to admin page.
 */
package ohtu.radioaine.controller;

import java.util.List;
import javax.validation.Valid;
import ohtu.radioaine.domain.*;
import ohtu.radioaine.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ohtu.radioaine.tools.Time;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controllers for admin page.
 *
 * @author rmjheino
 *
 */
@Controller
public class AdminController {

    @Autowired
    private SubstanceService substanceService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private BatchService batchService;
    @Autowired
    private EluateService eluateService;
    @Autowired
    private RadioMedService radioMedService;

    @RequestMapping("admin")
    public String adminView(Model model) {
        model.addAttribute("substances", substanceService.list());
        model.addAttribute("warning", Time.getWarningDate());
        return "admin";
    }

    @RequestMapping("management")
    public String managementView(Model model) {
        return "management";
    }

    @RequestMapping("substanceView")
    public String substancesUpdate(Model model) {
        model.addAttribute("substances", substanceService.list());
        return "substanceView";
    }

    @RequestMapping(value = "addStorage", method = RequestMethod.GET)
    public String addStorageView(Model model) {
        model.addAttribute("storage", new StorageFormObject());
        return "addStorageView";
    }

    @RequestMapping(value = "addStorage", method = RequestMethod.POST)
    public String addStorage(@Valid @ModelAttribute("storage") StorageFormObject sfo, BindingResult result) {
        if (result.hasErrors()) {
            return "addStoragesView";
        }
        storageService.createOrUpdate(createStorage(sfo));
        return "redirect:/storagesView";
    }

    @RequestMapping("storagesView")
    public String storageView(Model model) {
        model.addAttribute("storages", storageService.list());
        return "storagesView";
    }

    private Storage createStorage(StorageFormObject sfo) {
        Storage storage = new Storage();
        storage.setName(sfo.getName());

        return storage;
    }
    
    @RequestMapping(value = "updateStorageName/{id}", method = RequestMethod.POST)
    public String updateStorageName(@RequestParam String name, @PathVariable Integer id) {
        Storage temp = storageService.read(id);
        temp.setName(name);
        storageService.createOrUpdate(temp);
        System.out.println("uusi nimi on: " + storageService.read(id).getName());
        return "redirect:/storagesView";
    }
    
    @RequestMapping(value = "removeStorageName/{id}", method = RequestMethod.POST)
    public String removeStorageName(@PathVariable Integer id) {
        List<Batch> batchList = batchService.list();
        List<Eluate> eluateList = eluateService.list();
        List<RadioMedicine> radioMedicineList = radioMedService.list();
        
        //removes the storage only if it is not used in any batches, eluates or radiomedicines
        for(Batch batch : batchList)    {
            int[][] locations = batch.getStorageLocations();
            for(int i=0; i < locations.length; i++) {
                if(locations[i][0] == id)
                    return "redirect:/storagesView";
            }
        }
        for(Eluate eluate : eluateList)    {
            if(eluate.getStorageLocation() == id)
                return "redirect:/storagesView";
        }
        for(RadioMedicine radioMedicine : radioMedicineList)    {
            if(radioMedicine.getStorageLocation() == id)
                return "redirect:/storagesView";
        }
        
        storageService.delete(id);
        return "redirect:/storagesView";
    }

    @RequestMapping(value = "addStatusComment/{sid}+{cid}")
    public String addStatusComment(@RequestParam String comment,
            @PathVariable Integer sid,
            @PathVariable Integer cid) {
        Substance temp = (Substance) substanceService.read(sid);
        String[] comments = temp.getStatusMessages();
        comments[cid] = comment;
        temp.setStatusMessages(comments);
        substanceService.createOrUpdate(temp);
        return "redirect:/admin";
    }
}
