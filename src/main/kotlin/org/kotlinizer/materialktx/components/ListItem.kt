package org.kotlinizer.materialktx.components

import kotlinx.html.*

class MwcListItemTag(
    initialAttributes: Map<String, String>,
    override val consumer: TagConsumer<*>
) : HTMLTag(
    tagName = "mwc-list-item",
    consumer = consumer,
    initialAttributes = initialAttributes,
    namespace = null,
    inlineTag = false,
    emptyTag = false
), HtmlBlockTag, ImportListItem

@HtmlTagMarker
inline fun MwcListTag.mwcListItem(
    crossinline block: MwcListItemTag.() -> Unit = {}
) = MwcListItemTag(emptyMap, consumer).visit(block)

@JsNonModule
@JsModule("@material/mwc-list-item")
private external interface ImportListItem