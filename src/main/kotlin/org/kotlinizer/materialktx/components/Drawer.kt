package org.kotlinizer.materialktx.components

import kotlinx.html.*
import org.kotlinizer.materialktx.AttributesBoolean


open class MwcDrawerTag(
    initialAttributes: Map<String, String>,
    override val consumer: TagConsumer<*>
) : HTMLTag(
    tagName = "mwc-drawer",
    consumer = consumer,
    initialAttributes = initialAttributes,
    namespace = null,
    inlineTag = false,
    emptyTag = false
), HtmlBlockTag, ImportDrawer {

    var open: Boolean by AttributesBoolean()
}

@HtmlTagMarker
inline fun FlowContent.mwcDrawer(
    type: String = "modal",
    hasHeader: Boolean = true,
    crossinline block: MwcDrawerTag.() -> Unit = {}
) {
    MwcDrawerTag(
        mapOf(
            "hasHeader" to hasHeader.toString(),
            "type" to type
        ), consumer
    ).visit(block)
}

@JsNonModule
@JsModule("@material/mwc-drawer")
private external interface ImportDrawer