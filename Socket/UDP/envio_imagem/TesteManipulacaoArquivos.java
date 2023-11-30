public class TesteManipulacaoArquivos {
	public static void main(String args[]) throws Exception {
		String caminhoOrigem = "C:/users/asus/Desktop/civic.jpg"; 
		String caminhoDestino = "C:/users/asus/Desktop/civic2.jpg";
		
		ManipulacaoArquivos ma = new ManipulacaoArquivos();
		byte[] a = ma.deImagemParaArray(caminhoOrigem);
		ma.deArrayParaImagem(a, caminhoDestino);	
	}
}