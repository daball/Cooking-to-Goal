package com.customfit.ctg.gui;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class GUIFormats {
	static public Font getTitleFont() {
		Font font = new Font("Serif", Font.BOLD, 32);
		
		return font;
	}

        static public Border getPaddingBorder() {
            return BorderFactory.createEmptyBorder(5, 5, 5, 5);
	}
}
