DESCRIPTION = "Recipe to add a file to fs"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://data.txt"

S = "${WORKDIR}"

do_install() {
	install -d "${D}${bindir}"
	install -m 0755 data.txt "${D}${bindir}"
}

FILES_${PN} += "${D}${bindir}/"
ALLOW_EMPTY_${PN} = "1"
