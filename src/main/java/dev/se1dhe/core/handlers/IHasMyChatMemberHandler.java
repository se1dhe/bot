package dev.se1dhe.core.handlers;

import dev.se1dhe.core.bots.AbstractTelegramBot;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMemberUpdated;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public interface IHasMyChatMemberHandler extends ITelegramHandler {
	/**
	 * Fired whenever has my chat member is received
	 *
	 * @param bot               the bot
	 * @param update            the update
	 * @param chatMemberUpdated the chat member
	 * @return {@code true} if handler 'consumed' that event, aborting notification to other handlers, {@code false} otherwise, continuing to look for handler that would return {@code true}
	 * @throws TelegramApiException the exception
	 */
	boolean onHasMyChatMember(AbstractTelegramBot bot, Update update, ChatMemberUpdated chatMemberUpdated) throws TelegramApiException;
}
