package org.kotlinizer.materialktx.components

import kotlinx.html.*

class MwcButtonTag(
    initialAttributes: Map<String, String>,
    override val consumer: TagConsumer<*>
) : HTMLTag(
    tagName = "mwc-button",
    consumer = consumer,
    initialAttributes = initialAttributes,
    namespace = null,
    inlineTag = false,
    emptyTag = false
), HtmlBlockTag, ImportButton

@HtmlTagMarker
inline fun FlowContent.mwcButton(
    crossinline block: MwcButtonTag.() -> Unit = {}
) = MwcButtonTag(emptyMap, consumer).visit(block)

@JsNonModule
@JsModule("@material/mwc-button")
private external interface ImportButton