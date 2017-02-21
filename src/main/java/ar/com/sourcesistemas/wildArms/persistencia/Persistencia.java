package ar.com.sourcesistemas.wildArms.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ar.com.sourcesistemas.wildArms.entities.Constantes;

@Repository
public class Persistencia {

	private String prefix;
	private String uri = "example:uri";
	private String sistemaOperativo;
	private String userHome;

	
	public String getPrefix(){
		
		return prefix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public Persistencia() throws IOException {

		sistemaOperativo = System.getProperty("os.name");
		userHome = System.getProperty("user.home") + "/";
		prefix = userHome + Constantes.NOMBRE_CARPETA+"/";
		inicializarCarpetas();

	}

	private void inicializarCarpetas() throws IOException {

		boolean exists;
		exists = new File(userHome + "/wildArms").exists();

		if (!exists) {

			new File(userHome + "wildArms").mkdir();

		}

	}

	public boolean existeArchivo(String filename) {

		return new File(prefix + filename).exists();

	}


	
	public void save(String filename, Object obj) throws IOException {

		if (existeArchivo(filename)) {
			
			eliminarYCrearArchivo(filename);
		}
			FileOutputStream fileOut;
			ObjectOutputStream obj_out = null;
			try {
				fileOut = new FileOutputStream(prefix + filename);
				obj_out = new ObjectOutputStream(fileOut);
				obj_out.writeObject(obj);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				obj_out.close();

			}

	}

	public Object recoverFile(String filename) {
		File file = new File(prefix + filename);
		
		
		if (file.exists()) {
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream(file));
				return  ois.readObject();

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				try {
					if (ois != null)
						ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	public void eliminarYCrearArchivo(String filename) throws IOException {
		File file = new File(prefix + filename);
		if (file.exists())
			file.delete();
		file.createNewFile();
	}

	public void deleteFile(String filename) {
		File file = new File(prefix + filename);
		file.delete();
	}

	public void createFolder(String name) {
		new File(prefix+name).mkdir();

	}
	
	public String[] findAllFiles(String name ){
		
		if(name == null){
			return new File(prefix).list();
			
		}else{
			return new File(prefix+name).list();
			
		}
		
	}

	public List<Object> loadAll() {
		String[] findAllFiles = findAllFiles(null);
		
		List<Object> list= new LinkedList<Object>();
		for (int i = 0; i < findAllFiles.length; i++) {
			
			Object recoverFile = recoverFile(findAllFiles[i]);
			list.add(recoverFile);
			
		}
		
		return list;
		
	}


}