import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ManipulacaoArquivos {

	//Transforma uma imagem jpg em um array de bytes
	public byte[] deImagemParaArray(String caminhoImagem) throws Exception {
        // crio a imagem
		BufferedImage imagem = ImageIO.read(new File(caminhoImagem));   
        // crio um OutputStream de array de bytes
		ByteArrayOutputStream baos = new ByteArrayOutputStream();   
        // Uso o write pra escrever os dados da imagem no OutputStream do array de bytes
		ImageIO.write(imagem, "jpg", baos);   
        // retorno o array de bytes
		return baos.toByteArray();
    }
	
	//Transforma um array de bytes em uma imagem jpg
	public void deArrayParaImagem(byte[] imgBytes, String caminhoNovaImagem) throws Exception {
		//Obtem o OutputStream do Arquivo gravar dentro dele
        FileOutputStream fos = new FileOutputStream(caminhoNovaImagem);
		//escreve os bytes no arquivo especificado na criação do FileOutputStream
        fos.write(imgBytes);
        FileDescriptor fd = fos.getFD();
		//salva o conteúdo do buffer FileOutputStream no arquivo indicado 
        fos.flush();
        fd.sync();
        fos.close();
    }
}
