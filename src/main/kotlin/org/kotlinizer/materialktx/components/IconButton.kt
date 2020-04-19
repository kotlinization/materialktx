package org.kotlinizer.materialktx.components

import kotlinx.html.*

class MwcIconButtonTag(
    initialAttributes: Map<String, String>,
    override val consumer: TagConsumer<*>
) : HTMLTag(
    tagName = "mwc-icon-button",
    consumer = consumer,
    initialAttributes = initialAttributes,
    namespace = null,
    inlineTag = false,
    emptyTag = false
), HtmlBlockTag, ImportIconButton {

    var icon: String
        get() = attributes["icon"] ?: ""
        set(newValue) {
            attributes["icon"] = newValue
        }
}

@HtmlTagMarker
inline fun FlowContent.mwcIconButton(
    crossinline block: MwcIconButtonTag.() -> Unit = {}
) = MwcIconButtonTag(emptyMap, consumer).visit(block)

@JsNonModule
@JsModule("@material/mwc-icon-button")
private external interface ImportIconButton