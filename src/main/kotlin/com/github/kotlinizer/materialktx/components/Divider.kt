package com.github.kotlinizer.materialktx.components

import kotlinx.html.*

class MwcDividerTag(
    initialAttributes: Map<String, String>,
    override val consumer: TagConsumer<*>
) : HTMLTag(
    tagName = "li",
    consumer = consumer,
    initialAttributes = mapOf(
        "divider" to "",
        "role" to "separator"
    ),
    namespace = null,
    inlineTag = false,
    emptyTag = false
), HtmlBlockTag


@HtmlTagMarker
inline fun MwcListTag.mwcDivider(
    crossinline block: MwcDividerTag.() -> Unit = {}
) = MwcDividerTag(emptyMap, consumer).apply {
    visit {
        block()
    }
}