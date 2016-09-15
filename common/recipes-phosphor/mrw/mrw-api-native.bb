SUMMARY = "Phosphor OpenBMC machine readable workbook API modules"
DESCRIPTION = "The API for the MRW XML generated by the Serverwiz tool"
PR = "r1"

S = "${WORKDIR}/scripts"

inherit obmc-phosphor-license
inherit native
inherit perlnative
inherit cpan-base
inherit mrw-rev

DEPENDS += "libxml-simple-perl-native json-perl-native"

SRC_URI += "${MRW_API_SRC_URI}"
SRCREV = "${MRW_API_SRCREV}"

do_install() {
    install -d ${D}${PERLLIBDIRS_class-native}/perl/site_perl/${PERLVERSION}/mrw
    install -m 0755 Targets.pm ${D}${PERLLIBDIRS_class-native}/perl/site_perl/${PERLVERSION}/mrw/Targets.pm
}
