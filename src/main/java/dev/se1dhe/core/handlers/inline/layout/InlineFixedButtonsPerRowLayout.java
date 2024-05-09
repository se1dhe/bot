package dev.se1dhe.core.handlers.inline.layout;

import java.util.ArrayList;
import java.util.List;

import dev.se1dhe.core.handlers.inline.InlineButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;


public class InlineFixedButtonsPerRowLayout implements IInlineMenuLayout {
	private final int maxButtonsPerRow;
	
	/**
	 * Creates new Inline Fixed Buttons per row layout
	 *
	 * @param maxButtonsPerRow buttons per row
	 */
	public InlineFixedButtonsPerRowLayout(int maxButtonsPerRow) {
		this.maxButtonsPerRow = maxButtonsPerRow;
	}
	
	@Override
	public InlineKeyboardMarkup generateLayout(List<InlineButton> buttons) {
		final List<InlineKeyboardRow> keyboard = new ArrayList<>();
		buttons.forEach(uiButton ->
		{
			final InlineKeyboardButton button = uiButton.createInlineKeyboardButton();
			if (keyboard.isEmpty() || uiButton.isForceNewRow() || (keyboard.get(keyboard.size() - 1).size() >= maxButtonsPerRow)) {
				keyboard.add(new InlineKeyboardRow());
			}
			keyboard.get(keyboard.size() - 1).add(button);
		});
		return InlineKeyboardMarkup.builder().keyboard(keyboard).build();
	}
}
