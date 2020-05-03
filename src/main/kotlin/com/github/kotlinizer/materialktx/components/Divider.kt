package com.github.kotlinizer.materialktx.components

import com.github.kotlinizer.materialktx.AttributesBoolean
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
), HtmlBlockTag {
    var inset: Boolean by AttributesBoolean()

    var padded: Boolean by AttributesBoolean()
}


@HtmlTagMarker
inline fun MwcListTag.mwcDivider(
    crossinline block: MwcDividerTag.() -> Unit = {}
) = MwcDividerTag(emptyMap, consumer).apply {
    visit {
        block()
    }
}