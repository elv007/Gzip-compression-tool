import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CompressionToolGUI extends JFrame {
    private JTextField sourceField;
    private JTextField destField;
    private JButton compressButton;
    private JButton decompressButton;
    private Logger logger;

    public CompressionToolGUI() {
        setTitle("File Compression Tool");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            logger = new Logger("app.log");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error initializing logger: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        sourceField = new JTextField(20);
        destField = new JTextField(20);
        compressButton = new JButton("Compress");
        decompressButton = new JButton("Decompress");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Source File:"));
        panel.add(sourceField);
        panel.add(new JLabel("Destination File:"));
        panel.add(destField);
        panel.add(compressButton);
        panel.add(decompressButton);

        add(panel);

        setVisible(true);
    }

    public JTextField getSourceField() {
        return sourceField;
    }

    public JTextField getDestField() {
        return destField;
    }

    public JButton getCompressButton() {
        return compressButton;
    }

    public JButton getDecompressButton() {
        return decompressButton;
    }

    public Logger getLogger() {
        return logger;
    }
}
