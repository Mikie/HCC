/*
 *     Copyright (C) 2018  Hyperium <https://hyperium.cc/>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package cc.hyperium.handlers.handlers.chat;

import cc.hyperium.utils.SafeNumberParsing;
import net.minecraft.util.IChatComponent;

import java.util.regex.Matcher;

/**
 * @author Sk1er
 */
public class RankedRatingChatHandler extends HyperiumChatHandler {

    @Override
    public boolean chatReceived(IChatComponent component, String text) {
        Matcher matcher = regexPatterns.get(ChatRegexType.SKYWARS_RATING).matcher(text);
        if (matcher.matches()) {
            getHyperium().getHandlers().getValueHandler().setRankedRating(SafeNumberParsing.safeParseInt(matcher.group("rating"), getHyperium().getHandlers().getValueHandler().getRankedRating()));
            getHyperium().getHandlers().getValueHandler().setDeltaRankedRating(SafeNumberParsing.safeParseInt(matcher.group("change"), getHyperium().getHandlers().getValueHandler().getDeltaRankedRating()));
        }
        return false;
    }
}
