package gg.virtualclient

apply(plugin = "gg.virtualclient.defaults.mixin-extras")

pluginManager.withPlugin("java") { apply(plugin = "gg.virtualclient.defaults.java") }
pluginManager.withPlugin("gg.essential.loom") { apply(plugin = "gg.virtualclient.defaults.loom") }
