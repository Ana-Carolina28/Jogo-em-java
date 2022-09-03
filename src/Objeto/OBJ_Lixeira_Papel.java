package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Lixeira_Papel extends SuperObjeto {
	
	public OBJ_Lixeira_Papel() {
			
		nome = "Lixeira_Papel";
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/lixeira_papel.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		colisao = true;
			
	}

}
