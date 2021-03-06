/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.radioaine.service;

import java.sql.Timestamp;
import java.util.List;
import ohtu.radioaine.domain.RadioMedicine;

/**
 *
 * @author Richard Moneybags
 */
public interface RadioMedService {
    public RadioMedicine createOrUpdate(RadioMedicine radioMedicine);
    public List<RadioMedicine> list();
    public RadioMedicine read(Long id);
    public void delete(Long id);

    public List<RadioMedicine> list(Timestamp startDate, Timestamp endDate);
}
