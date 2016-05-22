/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.rendering.internal.parser.markdown;

import java.util.Collections;

import org.pegdown.ast.StrongEmphSuperNode;
import org.xwiki.rendering.listener.Format;

/**
 * Implements Pegdown Visitor's formatting events.
 *
 * @version $Id: e8eade34d5621dadc151a8caaa0919084c62a279 $
 * @since 4.5M1
 */
public abstract class AbstractFormattingPegdownVisitor extends AbstractTextPegdownVisitor
{
    @Override
    public void visit(StrongEmphSuperNode node)
    {
        Format format = node.isStrong() ? Format.BOLD : Format.ITALIC;

        getListener().beginFormat(format, Collections.EMPTY_MAP);
        visitChildren(node);
        getListener().endFormat(format, Collections.EMPTY_MAP);
    }
}
