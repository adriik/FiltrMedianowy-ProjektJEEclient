<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>
<%@ page contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html>

<f:view>
    <html lang="pl">
        <head>
        	<meta charset="utf-8"/>
        	<link href="../resources/css/style.css" rel="stylesheet" type="text/css">
            <title>Adrian Plichta I4G3S1 - Filtr Medianowy</title>
        </head>
        <body>
        	
            <div id="top">
            	<h:panelGroup>
		            <h:form id="uploadForm" enctype="multipart/form-data">
	                	<h:outputLabel for="file" value="Wybierz plik" />
		                <t:inputFileUpload id="file" value="#{klient.uploadedFile}" required="true" />
		                <h:commandButton value="Wyślij" action="#{klient.submit}" />
		            </h:form>
	            	<h:form id="filterForm">
						<h:commandButton value="Filtruj" binding="#{klient.filtrButton}" action="#{klient.filtr}" rendered="false"></h:commandButton>
					</h:form>
				</h:panelGroup>
            </div>
            <div id="komunikaty">
					<h:message for="file" style="color: red;" /> 
                    <h:message for="uploadForm" infoStyle="color: green;" errorStyle="color: red;" /> 
           	</div>



            <div id="lewy_napis">
				<h:outputLabel for="image" value="Obraz wgrany na serwer: " ></h:outputLabel>
			</div>
			<div id="prawy_napis">
				<h:outputLabel for="filtr" value="Obraz po filtracji medianowej: " ></h:outputLabel>
			</div>

			<div id="lewy_obraz">
				<h:graphicImage id="image"  value="/obrazy/#{klient.fileName}" binding="#{klient.image}" rendered="false" alt="Obraz niedostepny" ></h:graphicImage>
			</div>
			<div id="prawy_obraz">
				<font color="red"><h:graphicImage id="filtr" value="#{klient.absolutePath}" rendered="false" binding="#{klient.image2}"   alt="Blad filtracji" ></h:graphicImage></font>
			</div>
        </body>
    </html>
</f:view>
</html>