package com.github.kotlinizer.materialktx.components

import com.github.kotlinizer.materialktx.AttributesBoolean
import com.github.kotlinizer.materialktx.AttributesString
import kotlinx.html.*
import kotlinx.html.attributes.Attribute

class MwcRadioListItem(
    initialAttributes: Map<String, String>,
    override val consumer: TagConsumer<*>
) : HTMLTag(
    tagName = "mwc-radio-list-item",
    consumer = consumer,
    initialAttributes = initialAttributes,
    namespace = null,
    inlineTag = false,
    emptyTag = false
), HtmlBlockTag, ImportRadioListItem {

    var group: String? by AttributesString()

    var left: Boolean by AttributesBoolean()




}

@HtmlTagMarker
inline fun MwcListTag.mwcRadioListItem(
    label: String? = null,
    crossinline block: MwcRadioListItem.() -> Unit = {}
) = MwcRadioListItem(emptyMap, consumer).apply {
    visit {
        if (label != null) {
            text(label)
        }
        block()
    }
}


@JsNonModule
@JsModule("@material/mwc-list/mwc-radio-list-item")
private external interface ImportRadioListItem