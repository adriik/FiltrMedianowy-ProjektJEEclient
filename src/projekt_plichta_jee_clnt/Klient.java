package projekt_plichta_jee_clnt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.faces.application.FacesMessage;
import javax.faces.component.UICommand;
import javax.faces.component.UIGraphic;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import projekt_plichta_jee_srvr.UploadProxy;

public class Klient {

    private UploadedFile uploadedFile;
    private String fileName;
    private String sciezka;
    private String suffix;
    private String prefix;
    private UIGraphic image, image2;
    private UICommand filtrButton;
    private String absolutePath;
    File file = null;
    
    public String submit(){
    	
        //System.out.println("File type: " + uploadedFile.getContentType());
        //System.out.println("File name: " + uploadedFile.getName());
        //System.out.println("File size: " + uploadedFile.getSize() + " bytes");

        // Prepare filename prefix and suffix for an unique filename in upload folder.
        prefix = FilenameUtils.getBaseName(uploadedFile.getName());
        suffix = FilenameUtils.getExtension(uploadedFile.getName());
        
        // Prepare file and outputstream.
       
        OutputStream output = null;
        
        try {
            // Create file with unique name in upload folder and write to it.
        	ServletContext svContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String baseDirectory = svContext.getRealPath("/");
            //System.out.println("Nowy: "+baseDirectory);
            file = File.createTempFile(prefix + "_", "." + suffix, new File(baseDirectory + "obrazy\\"));
            output = new FileOutputStream(file);
            IOUtils.copy(uploadedFile.getInputStream(), output);
            fileName = file.getName();
            sciezka = file.getPath();
            //System.out.println("Nazwa sciezka: " + getSciezka());

            // Show succes message.
            FacesContext.getCurrentInstance().addMessage("uploadForm", new FacesMessage(
                FacesMessage.SEVERITY_INFO, "File upload succeed!", null));
        } catch (IOException e) {
            // Cleanup.
            if (file != null) file.delete();

            // Show error message.
            FacesContext.getCurrentInstance().addMessage("uploadForm", new FacesMessage(
                FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", null));

            // Always log stacktraces (with a real logger).
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(output);
        }

        image.setRendered(true);
        
    	
        filtrButton.setRendered(true);
    	
    	return null;
    }
    
    public String filtr(){
    	
    	byte[] imageBytes = null;
    	
    	try {
    		Path path = Paths.get(getSciezka());
    		imageBytes = Files.readAllBytes(path);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


        UploadProxy client = new UploadProxy();

        try {
            //System.out.println("4");
            byte[] outBytes = client.upload("pobrane.png", imageBytes);
            //System.out.println("5");
            ServletContext svContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String baseDirectory = svContext.getRealPath("/");
            
            FileUtils.writeByteArrayToFile(new File(baseDirectory + "obrazy\\" + FilenameUtils.removeExtension(file.getName()) + "_" + "medianowy" + "." + suffix), outBytes);
            absolutePath = "obrazy\\" + FilenameUtils.removeExtension(file.getName()) + "_" + "medianowy" + "." + suffix;
            //System.out.println("6");

        } catch (IOException ex) {
        	
        	System.out.println("Web Service nie działa");
      
        }     
    	
    	
    	
    	image2.setRendered(true);
    	return null;
    }
    
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSciezka() {
		return sciezka;
	}
	public void setSciezka(String sciezka) {
		this.sciezka = sciezka;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public UIGraphic getImage() {
		return image;
	}
	public void setImage(UIGraphic image) {
		this.image = image;
	}
	public UICommand getFiltrButton() {
		return filtrButton;
	}
	public void setFiltrButton(UICommand filtrButton) {
		this.filtrButton = filtrButton;
	}

	public UIGraphic getImage2() {
		return image2;
	}

	public void setImage2(UIGraphic image2) {
		this.image2 = image2;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}
    
    
}
