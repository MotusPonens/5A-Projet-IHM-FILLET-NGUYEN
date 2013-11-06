<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
        
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/design.css" type="text/css">
        <title>Index - ProjectMVC</title>
    </head>
        
    <body>
            <div class="BandeSup">
            
        </div>
             
        <div class="Centre">
            <h1 class="Titre">Liste des Contacts</h1>
            <button class="button1" type="button" onclick="window.location.href='add-contact';">Ajouter un contact
            </button>
            <div style="height:400px;overflow:auto; border:solid black; background-color: #ffe1a5; color: 231100">
            ${contactManager.displayList()}
            </div>
        </div>
    </body>
</html>