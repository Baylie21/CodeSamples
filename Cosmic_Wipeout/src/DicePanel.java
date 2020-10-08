import javax.swing.*;

public class DicePanel extends JPanel
{
    private final Die_A dice;

    private JButton rollButton;
    private JLabel displayLabel;

    public DicePanel(Die_A dice)
    {
        this.dice = dice;

        rollButton = new JButton("Roll");
        displayLabel = new JLabel();

        rollButton.addActionListener(e ->
                displayLabel.setText("You rolled a: " + dice.getRoll())
        );
        // or if you're not using Java 8, you can do the more verbose thing.

        // not specifying a layout defaults to a flow layout.  Set a layout via:
        // setLayout(new BorderLayout()); // or whatever
        add(rollButton);
        add(displayLabel);
    }

    public static void main(String[] args)
    {
        Die_A die = new Die_A();
        DicePanel panel = new DicePanel(die);

    }
}