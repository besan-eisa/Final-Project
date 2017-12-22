/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugs;

/**
 *
 * @author besan
 */
public class Drugs {
    
    private String name;
    private String alternativeMedicine;
    private String descriptionAndComposition;
    private String sideEffects;
    private String bodyOrgans;
    private String view;
    
    public Drugs(){}
   
    public Drugs(String name) {
        
        this.name = name;
    }
    
    public Drugs(String name, String alternativeMedicine, String descriptionAndComposition, String sideEffects, String bodyOrgans, String view) {
        this.name = name;
        this.alternativeMedicine = alternativeMedicine;
        this.descriptionAndComposition = descriptionAndComposition;
        this.sideEffects = sideEffects;
        this.bodyOrgans = bodyOrgans;
        this.view = view;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlternativeMedicine() {
        return alternativeMedicine;
    }

    public void setAlternativeMedicine(String alternativeMedicine) {
        this.alternativeMedicine = alternativeMedicine;
    }

    public String getDescriptionAndComposition() {
        return descriptionAndComposition;
    }

    public void setDescriptionAndComposition(String descriptionAndComposition) {
        this.descriptionAndComposition = descriptionAndComposition;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getBodyOrgans() {
        return bodyOrgans;
    }

    public void setBodyOrgans(String bodyOrgans) {
        this.bodyOrgans = bodyOrgans;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    
    
}
