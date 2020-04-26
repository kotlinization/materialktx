package com.github.kotlinizer.materialktx.components

import kotlinx.html.*

class MwcIconTag(
    initialAttributes: Map<String, String>,
    override val consumer: TagConsumer<*>
) : HTMLTag(
    tagName = "mwc-icon",
    consumer = consumer,
    initialAttributes = initialAttributes,
    namespace = null,
    inlineTag = false,
    emptyTag = false
), HtmlBlockTag, ImportIcon


@HtmlTagMarker
inline fun FlowContent.mwcIcon(
    icon: String,
    crossinline block: MwcIconTag.() -> Unit = {}
) = MwcIconTag(emptyMap, consumer).apply {
    visit {
        text(icon)
        block()
    }
}

@JsNonModule
@JsModule("@material/mwc-icon")
private external interface ImportIcon