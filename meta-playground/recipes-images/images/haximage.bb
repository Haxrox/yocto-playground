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

# IMAGE_ROOTFS_SIZE ?= "8192"
# IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"