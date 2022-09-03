package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Lixeira_Metal extends SuperObjeto{
	
	public OBJ_Lixeira_Metal() {
		
		nome = "Lixeira_Metal";
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/lixeira_metal.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		colisao = true;
			
	}

}
