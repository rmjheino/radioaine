/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.radioaine.domain;

import javax.validation.constraints.NotNull;

/**
 *
 * @author jahyvone
 */
public class SubstanceFormObject {

    @NotNull(message = "Nimi ei saa olla tyhjä")
    private String name;
    private String genericName;
    private String eluateName;
    private int type;
    private int halflife;
    private int alertLimit1;
    private int alertLimit2;
    private int volume;
    private int strength;
    private int qualityControl;
    private boolean needsColdStorage;
    private String manufacturer;
    private String supplier;
    private String signature;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAlertLimit1() {
        return alertLimit1;
    }

    public void setAlertLimit1(int alertLimit1) {
        this.alertLimit1 = alertLimit1;
    }

    public int getAlertLimit2() {
        return alertLimit2;
    }

    public void setAlertLimit2(int alertLimit2) {
        this.alertLimit2 = alertLimit2;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getNeedsColdStorage() {
        return needsColdStorage;
    }

    public void setNeedsColdStorage(boolean needsColdStorage) {
        this.needsColdStorage = needsColdStorage;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getHalflife() {
        return halflife;
    }

    public void setHalflife(int halflife) {
        this.halflife = halflife;
    }

    public String getEluateName() {
        return eluateName;
    }

    public void setEluateName(String eluateName) {
        this.eluateName = eluateName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getQualityControl() {
        return qualityControl;
    }

    public void setQualityControl(int qualityControl) {
        this.qualityControl = qualityControl;
    }
}
