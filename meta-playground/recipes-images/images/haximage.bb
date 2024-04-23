SUMMARY = "Hax image"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_INSTALL += "hello                 \
                  hello-mod             \
                  python3               \
                  install-example       \
                  rust-hello-world      \
                 "

IMAGE_LINGUAS = " "
LICENSE = "MIT"

inherit core-image

IMAGE_FSTYPES:append = " wic jffs2 tar.gz ubifs"

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = " ${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

IMAGE_FEATURES:append = " allow-empty-password empty-root-password"

IMAGE_INSTALL:append = " mtd-utils"
# IMAGE_ROOTFS_SIZE ?= "8192"
# IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

WKS_FILE = "sdimage-cyclone5-arria5.wks"
WKS_FILE_DEPENDS = "virtual/bootloader"