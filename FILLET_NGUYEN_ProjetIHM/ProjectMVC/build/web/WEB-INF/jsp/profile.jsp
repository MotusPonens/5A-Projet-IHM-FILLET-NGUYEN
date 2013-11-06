<%-- 
    Document   : profile
    Created on : 31 oct. 2013, 17:57:49
    Author     : nath
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/design.css" type="text/css">
        <title>${Contact.getName()} ${Contact.getSurname()} - ProjectMVC</title>
    </head>
    <body>
        
        <div class="BandeSup">
            
        </div>
        
        <div class="Centre">
            <div>
                <h1 class="Titre">Contact</h1>
                
            </div>
            <div class="info">
                <button class="button1" type="button" onclick="window.location.href='index';">Page Principale
                </button>
                <h2>Informations</h2>
                <form name="input" action="modify-contact" method="get">
                    <input type="hidden" name="id" value=${Contact.getId()}>
                    Prénom : <input class="zone" type="text" name="name" maxlength="20" value=${Contact.getName()}><br/>
                    Nom : <input class="zone" type="text" name="surname" maxlength="20" value=${Contact.getSurname()}><br/>
                    e-mail : <input class="zone" type="email" size="40"  maxlength="20" name="email" value=${Contact.getEmail()}><br/>
                    Date de naissance :
                    <input class="zone" type="date" name="date" value="${Contact.getYear()}-${Contact.getMonth()}-${Contact.getDate()}">
                    <input type="submit" value="Enregistrer">
                </form>
            </div>
            <div class="info">
                <h2>Adresses du contact</h2>
                <button type="button" onclick="window.location.href='add-adress?id=${Contact.getId()}';">Ajouter une adresse</button>
                <!--<table border="1" rules="rows">
                    <tr>
                        <th width="55px" >N°</th>
                        <th width="163px">Rue</th>
                        <th width="118px">Code Postal</th>
                        <th width="117px">Ville</th>
                    </tr>
                </table>
                -->
                <div style="height:100px;overflow:auto;">
                ${Contact.displayList()}
                </div>
            </div>
        </div>
    </body>
</html>
