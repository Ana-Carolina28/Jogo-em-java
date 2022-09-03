package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Garrafa_Tutorial extends SuperObjeto{
	
public OBJ_Garrafa_Tutorial() {
		
		nome = "Garrafa_Tutorial";
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/garrafa.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
