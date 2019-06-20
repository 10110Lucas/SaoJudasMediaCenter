package br.usjt.MediaCenter.test.exemplos;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;


public class RedimencionaImagem {
	
	public static void setDimensao(byte[] file, Integer imgLargura, Integer imgAltura) {
        Double novaImgLargura = null;
        Double novaImgAltura = null;
        Double imgProporcao = null;
        Graphics2D g2d = null;
        BufferedImage imagem = null, novaImagem = null;
        InputStream input = new ByteArrayInputStream(file);

        try {
            //--- Obtém a imagem a ser redimensionada ---
            imagem = ImageIO.read(input);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ManipularImagem.class.getName()).log(Level.SEVERE, null, ex);
        }

        //--- Obtém a largura da imagem ---  
        novaImgLargura = (double) imagem.getWidth();

        //--- Obtám a altura da imagem ---  
        novaImgAltura = (double) imagem.getHeight();

    //--- Verifica se a altura ou largura da imagem recebida é maior do que os ---  
        //--- parâmetros de altura e largura recebidos para o redimensionamento   ---  
        if (novaImgLargura >= imgLargura) {
            imgProporcao = (novaImgAltura / novaImgLargura);//calcula a proporção  
            novaImgLargura = (double) imgLargura;

            //--- altura deve <= ao parâmetro imgAltura e proporcional a largura ---  
            novaImgAltura = (novaImgLargura * imgProporcao);

        //--- se altura for maior do que o parâmetro imgAltura, diminui-se a largura de ---  
            //--- forma que a altura seja igual ao parâmetro imgAltura e proporcional a largura ---  
            while (novaImgAltura > imgAltura) {
                novaImgLargura = (double) (--imgLargura);
                novaImgAltura = (novaImgLargura * imgProporcao);
            }
        } else if (novaImgAltura >= imgAltura) {
            imgProporcao = (novaImgLargura / novaImgAltura);//calcula a proporção  
            novaImgAltura = (double) imgAltura;

        //--- se largura for maior do que o parâmetro imgLargura, diminui-se a altura de ---  
            //--- forma que a largura seja igual ao parâmetro imglargura e proporcional a altura ---  
            while (novaImgLargura > imgLargura) {
                novaImgAltura = (double) (--imgAltura);
                novaImgLargura = (novaImgAltura * imgProporcao);
            }
        }

        novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(), BufferedImage.TYPE_INT_RGB);
        g2d = novaImagem.createGraphics();
        g2d.drawImage(imagem, 0, 0, novaImgLargura.intValue(), novaImgAltura.intValue(), null);
    }

}
