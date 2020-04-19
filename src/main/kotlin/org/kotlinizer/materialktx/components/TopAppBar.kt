package org.kotlinizer.materialktx.components

import kotlinx.html.*

class MwcTopAppBarTag(
    initialAttributes: Map<String, String>,
    override val consumer: TagConsumer<*>
) : HTMLTag(
    tagName = "mwc-top-app-bar",
    consumer = consumer,
    initialAttributes = initialAttributes,
    namespace = null,
    inlineTag = false,
    emptyTag = false
), HtmlBlockTag, ImportTopAppBar {

    companion object {
        const val NAV_EVENT = "MDCTopAppBar:nav"
    }
}

@HtmlTagMarker
inline fun FlowContent.mwcTopAppBar(
    crossinline block: MwcTopAppBarTag.() -> Unit = {}
) = MwcTopAppBarTag(emptyMap, consumer).visit(block)

@JsNonModule
@JsModule("@material/mwc-top-app-bar")
private external interface ImportTopAppBar