package com.github.kotlinizer.materialktx.components

import com.github.kotlinizer.materialktx.AttributesBoolean
import com.github.kotlinizer.materialktx.AttributesString
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
), HtmlBlockTag, ImportButton {

    var icon: String? by AttributesString()

    var label: String? by AttributesString()

    var outlined: Boolean by AttributesBoolean()

    var raised: Boolean by AttributesBoolean()

    var unelevated: Boolean by AttributesBoolean()

    var dense: Boolean by AttributesBoolean ()

    var trailingicon: Boolean by  AttributesBoolean()

    var disabled: Boolean by AttributesBoolean ()



}

@HtmlTagMarker
inline fun FlowContent.mwcButton(
    label: String,
    crossinline block: MwcButtonTag.() -> Unit = {}
) {
    MwcButtonTag(attributesMapOf("label", label), consumer).visit(block)
}

@JsNonModule
@JsModule("@material/mwc-button")
private external interface ImportButton