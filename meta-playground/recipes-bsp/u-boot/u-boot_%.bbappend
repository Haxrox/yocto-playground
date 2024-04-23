
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

BRANCH = "master"
SRC_URI = "git://github.com/Haxrox/u-boot.git;protocol=https;branch=${BRANCH}       \
           file://0001-de1-soc-header-files.patch                                   \
          "

LICENSE = "CLOSED"

SRCREV = "bd0aedde3ea3691616c17c720e2d25351308c0a1"
SRC_URI[sha256sum] = "713f99b76df0238fe733f1664249ac34c2772f08df9cddac267526f0480b64ae"

S = "${WORKDIR}/git"

# do_compile() {
#   make -j8 CROSS_COMPILE=arm-none-eabi socfpga_de1_soc_defconfig
#   CROSS_COMPILE=arm-none-eabi- make -j8
# }