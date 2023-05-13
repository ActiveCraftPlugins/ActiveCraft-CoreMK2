package dev.activecraft.activecraftcore.exceptions

import dev.activecraft.activecraftcore.exceptions.ActiveCraftException

class StartupException(val shutdown: Boolean, message: String?) : ActiveCraftException(message)