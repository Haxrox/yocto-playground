SUMMARY = "An example kernel recipe that uses the linux-yocto and oe-core"
# linux-yocto-custom.bb:
#
#   kernel classes to apply a subset of yocto kernel management to git
#   managed kernel repositories.
#
#   To use linux-yocto-custom in your layer, copy this recipe (optionally
#   rename it as well) and modify it appropriately for your machine. i.e.:
#
#     COMPATIBLE_MACHINE_yourmachine = "yourmachine"
#
#   You must also provide a Linux kernel configuration. The most direct
#   method is to copy your .config to files/defconfig in your layer,
#   in the same directory as the copy (and rename) of this recipe and
#   add file://defconfig to your SRC_URI.
#
#   To use the yocto kernel tooling to generate a BSP configuration
#   using modular configuration fragments, see the yocto-bsp and
#   yocto-kernel tools documentation.
#
# Warning:
#
#   Building this example without providing a defconfig or BSP
#   configuration will result in build or boot errors. This is not a
#   bug.
#
#
# Notes:
#
#   patches: patches can be merged into to the source git tree itself,
#            added via the SRC_URI, or controlled via a BSP
#            configuration.
#
#   defconfig: When a defconfig is provided, the linux-yocto configuration
#              uses the filename as a trigger to use a 'allnoconfig' baseline
#              before merging the defconfig into the build. 
#
#              If the defconfig file was created with make_savedefconfig, 
#              not all options are specified, and should be restored with their
#              defaults, not set to 'n'. To properly expand a defconfig like
#              this, specify: KCONFIG_MODE="--alldefconfig" in the kernel
#              recipe.
#   
#   example configuration addition:
#            SRC_URI += "file://smp.cfg"
#   example patch addition (for kernel v4.x only):
#            SRC_URI += "file://0001-linux-version-tweak.patch"
#   example feature addition (for kernel v4.x only):
#            SRC_URI += "file://feature.scc"
#

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

KERNEL_BRANCH="haxrox/linux-6.6-rc7"
META_BRANCH="haxrox/yocto-6.6"
# KERNEL_BRANCH="haxrox/yocto-6.6"
# META_BRANCH="haxrox/yocto-6.6"
# Override SRC_URI in a copy of this recipe to point at a different source
# tree if you do not want to build from Linus' tree.
SRC_URI = "git://github.com/Haxrox/linux;protocol=https;branch=${KERNEL_BRANCH};name=machine                 \
           git://github.com/Haxrox/yocto-kernel-cache.git;protocol=https;branch=${META_BRANCH};type=kmeta;destsuffix=kernel-meta;name=meta \
          "

SRC_URI += "file://defconfig"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

# SRC_URI[linux.sha256sum] = "af4ba4404109797755cec54e8c8892f2b57facc98a98bf927de7479ef61ff005"
# SRC_URI[yocto-kernel-cache.sha256sum] = "1184850db263970bf46a9cf54af47feb1f91648eb8af657989fb8b9165980f83"

LINUX_VERSION ?= "6.6-rc7"
LINUX_VERSION_EXTENSION:append = "-haxrox"
KCONFIG_MODE = "--alldefconfig"

# Modify SRCREV to a different commit hash in a copy of this recipe to
# build a different release of the Linux kernel.
# tag: v4.2 64291f7db5bd8150a74ad2036f1037e6a0428df2
SRCREV_machine = "05d3ef8bba77c1b5f98d941d8b2d4aeab8118ef1"
SRCREV_meta = "525b3f188e0bfb1cdcca241db89ef265842205cd"

PV = "${LINUX_VERSION}+git${SRCPV}"

# Override COMPATIBLE_MACHINE to include your machine in a copy of this recipe
# file. Leaving it empty here ensures an early explicit build failure.
COMPATIBLE_MACHINE = "(qemux86|qemux86-64|genericx86-64)"