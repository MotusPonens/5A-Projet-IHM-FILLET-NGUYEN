/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihm.contacts;

import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts;
    private int idMax=1;
    
    public ContactManager(){
        contacts = new ArrayList<Contact>();
        initList();
    }
    
    private void initList(){
        contacts = new ArrayList<Contact>();
        createContact("Philipe","Bayeux","philipe.bayeux@gmail.fr","1963","03","21");
        createContact("Pascale","Dassini","pascale.dassini1965@gmail.fr","1965","11","26");
        createContact("Hélène","Fiantre","helene.fiantre@hotmail.fr","1972","04","05");
        createContact("Marc","Chanterelle","marco_chantana@orange.fr","1982","09","03");
        
        findContactById(1).addAdresse(new Adress("24bis","Avenue Coubray","93125","Paris"));
        findContactById(2).addAdresse(new Adress("13","Avenue Renoir","93125","Paris"));
        findContactById(3).addAdresse(new Adress("2","Rue des Minières","93125","Paris"));
        findContactById(4).addAdresse(new Adress("11","Allée des Sarrasins","93125","Paris"));
    }
    
    public String displayList(){
        String list="<table border=\"1\" rules=\"all\">\n"+
        "<tr>\n"+
        "<th>Prénom</th>\n"+
        "<th>Nom</th>\n"+
        "<th>e-mail</th>\n"+
        "</tr>\n";
        //list+="<table border=\"1\" rules=\"all\">";
        
        if(contacts.isEmpty()){
            list+="<tr>\n<td>Aucun contact</td>\n<tr>\n";
            list+="</table>\n";
            return list;
        }
        
        for(int i=0;i<contacts.size();i++){
            list+="<tr>\n";
            list+="<td>"+contacts.get(i).getName()+"</td>\n";
            list+="<td>"+contacts.get(i).getSurname()+"</td>\n";
            list+="<td>"+contacts.get(i).getEmail()+"</td>\n";
            
            list+="<td><button type=\"button\" ";
            list+="onclick=\"window.location.href='profile?id="+contacts.get(i).getId()+"'\"";
            list+=">Voir profil</button></td>\n";
            
            list+="<td><button type=\"button\" ";
            list+="onclick=\"window.location.href='delete-contact?id="+contacts.get(i).getId()+"'\"";
            list+=">Supprimer</button></td>\n";
            list+="</tr>\n";
        }
        
        list+="</table>\n";
            
        return list;
    }

    public void createContact(String name, String surname, String email, String year, String month, String date){
        contacts.add(new Contact(idMax,name,surname,email,year,month,date));
        idMax++;
    }
    
    public void createContact(){
        contacts.add(new Contact(idMax,"prénom","nom","name@email.com","2000","01","01"));
        idMax++;
    }
    
    public Contact findContactById(int id){
        for(int i=0; i<contacts.size();i++){
            if(contacts.get(i).getId()==id){
                return contacts.get(i);
            }
        }
        return null;
    }
    
    public void removeContactById(int id){
        for(int i=0; i<contacts.size();i++){
            if(contacts.get(i).getId()==id){
                contacts.remove(i);
            }
        }
    }
    
    public int getIdMax(){
        return idMax;
    }
    
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}
