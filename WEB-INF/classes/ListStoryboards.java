import java.io.IOException;
import org.jdom.*;
import java.util.List;
import org.jdom.output.XMLOutputter;
import java.io.PrintWriter;
import java.io.FileWriter;
import org.jdom.input.SAXBuilder;
import org.jdom.input.DOMBuilder;
import java.io.FileInputStream;  
import java.io.FileOutputStream; 
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.StringWriter;
public class ListStoryboards {
        String ruta;
		List<CStoryBoard> stories = new ArrayList<>();
		Element storyXML;
		SAXBuilder builder;
		File xmlFile;
		Document document;
		int indiceTexto;
		Element rootNode;
		List list;

    public ListStoryboards(String ruta){
				this.ruta = ruta;
				try{
					builder = new SAXBuilder();
					xmlFile = new File(ruta);
					document = builder.build(xmlFile);
					rootNode = document.getRootElement();
					list = rootNode.getChildren("StoryBoard");
					}catch(Exception e){
						e.printStackTrace();
					}
		}


	public List<CStoryBoard> generateList() {

		for (int i = 0; i < list.size(); i++) {

           Element node = (Element) list.get(i);    
           if (node.getChildText("Texto") == null && node.getChildText("Video") == null){
				   List<String> slides = new ArrayList<>();
				   List l1 = node.getChild("Slides").getChildren();
				    
				   for (int j = 0; j < l1.size(); j++) {
						Element node2 = (Element)list.get(j);
						XMLOutputter outp = new XMLOutputter();
						
						StringWriter sw = new StringWriter();
						try {
							outp.output(node2.getContent(), sw);
						} catch (Exception e) {}
						
						StringBuffer sb = sw.getBuffer();
						slides.add(sb.toString());
					   
				   }
                stories.add(new CStoryBoard(node.getChildText("Nombre"),slides,node.getChildText("Tipo")));
           }
		}
    return stories;
	}
	/*public Texto getOneStory(String texto){

		Texto storytosend = new Texto();
		for (int i = 0; i < list.size(); i++) {
			 Element node = (Element) list.get(i);   
			 String name =  node.getChildText("Nombre");
			 if (name.equals(texto)) {
                storytosend.name = name;
                storytosend.tipo = node.getChildText("Tipo");
                storytosend.texto = node.getChildText("Video");
				storyXML = node;
				indiceTexto = i;
				return storytosend;
			 }	
		}

		return storytosend;
	}
	 //public void updateTexto(Element node,String Nombre,String Texto, String Tipo){
		node.getChild("Nombre").setText(Nombre);
		node.getChild("Texto").setText(Texto);
		node.getChild("Tipo").setText(Tipo);
		save();
	}
	public void deleteTexto(){
		list.remove(indiceTexto);
		save();
	}
	public void save(){
		try {
			XMLOutputter xmlout = new XMLOutputter();
			FileOutputStream fileout = new FileOutputStream(ruta);
			xmlout.output(document, fileout);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
