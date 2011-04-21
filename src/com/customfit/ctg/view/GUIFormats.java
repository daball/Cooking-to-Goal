package com.customfit.ctg.view;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class GUIFormats {
	public static Font getTitleFont() {
		Font font = new Font("Serif", Font.BOLD, 32);
		
		return font;
	}

        static public Border getPaddingBorder() {
            return BorderFactory.createEmptyBorder(5, 5, 5, 5);
	}
}
