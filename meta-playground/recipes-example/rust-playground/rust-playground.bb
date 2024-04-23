LICENSE = "CLOSED"

inherit cargo_bin

SRC_URI = "git://github.com/Haxrox/rust-playground;protocol=https;branch=main"
SRCREV = "8eb2d21f9e14e07a4d5d8ad6ec82218280037213"
PV = "1.0"

S = "${WORKDIR}/git"