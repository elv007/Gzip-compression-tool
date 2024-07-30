import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionHandler {
    private CompressionToolGUI gui;

    public ActionHandler(CompressionToolGUI gui) {
        this.gui = gui;
        initListeners();
    }

    private void initListeners() {
        gui.getCompressButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String source = gui.getSourceField().getText();
                String dest = gui.getDestField().getText();
                GZipCompression gzip = new GZipCompression();
                try {
                    gzip.compressFile(source, dest);
                    gui.getLogger().log("Compressed: " + source + " to " + dest);
                    JOptionPane.showMessageDialog(gui, "Compression successful!");
                } catch (IOException ex) {
                    gui.getLogger().log("Error compressing file: " + ex.getMessage());
                    JOptionPane.showMessageDialog(gui, "Error compressing file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gui.getDecompressButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String source = gui.getSourceField().getText();
                String dest = gui.getDestField().getText();
                GZipCompression gzip = new GZipCompression();
                try {
                    gzip.decompressFile(source, dest);
                    gui.getLogger().log("Decompressed: " + source + " to " + dest);
                    JOptionPane.showMessageDialog(gui, "Decompression successful!");
                } catch (IOException ex) {
                    gui.getLogger().log("Error decompressing file: " + ex.getMessage());
                    JOptionPane.showMessageDialog(gui, "Error decompressing file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
