package com.test.model;

public class JeanTemplateMap {
    private JeanEntity temp = new JeanEntity();

    public JeanEntity returnNewJeanEntity(String description, String category, String htmlColor){
        checkCropped(description, category);
        checkDistress(description, category);
        this.temp.setHtmlColor(htmlColor);


        return this.temp;


    }

    private void setStyle(String description, String category){

       //matches category against JeanStyle Enum directly
        for(JeanStyle style: JeanStyle.values()){
            if(style.toString().contains(category)){
                this.temp.setStyle(style);
                return;
            }
        }

        //matches for keywords in description to find JeanStyle
        String d = description.toLowerCase();
        if(d.contains("skinny") | d.contains("leggings")){
            this.temp.setStyle(JeanStyle.SKINNY);
            return;
        }else if(category.contains("Classic")| d.contains("straight")){
            this.temp.setStyle(JeanStyle.STRAIGHT);
        }
        else if(d.contains("relaxed")){
            this.temp.setStyle(JeanStyle.RELAXED);
            return;
        }else if(d.contains("flare")){
            this.temp.setStyle(JeanStyle.FLARE);
            return;
        }else if(d.contains("bootcut")){
            this.temp.setStyle(JeanStyle.BOOTCUT);
            return;
        }


    }


    /*  @param description - gathered from ShopStyleAPI
        @param category - gathered from ShopStyle API
        tests parameters for keywords to set JeanEntity boolean distressed
        default returns false
     */

    private void checkDistress(String description, String category) {
        if (category.contains("Distressed")) {
            this.temp.setDistressed(true);
            return;
        }
        String d = description.toLowerCase();
        if (d.contains("hole") | d.contains("distress")) {
            this.temp.setDistressed(true);
            return;
        }
        this.temp.setDistressed(false);
    }

    /*  @param description - gathered from ShopStyleAPI
        @param category - gathered from ShopStyle API
        tests parameters for keywords to set JeanEntity boolean cropped
        default returns false
     */
    private void checkCropped(String description, String category){
        if(category.contains("Cropped")){
            this.temp.setCropped(true);
            return;
        }

        String d = description.toLowerCase();
        if(d.contains("ankle")|d.contains("crop")|d.contains("capri")){
            this.temp.setCropped(true);
            return;
        }
        this.temp.setCropped(false);
    }



}
