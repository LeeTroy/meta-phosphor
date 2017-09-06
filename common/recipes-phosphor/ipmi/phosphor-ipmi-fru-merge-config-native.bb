SUMMARY = "To merge the Host and BMC config files generated from MRW "
DESCRIPTION = "Merge host provided FRU info config file and \
BMC accessible FRU info config files generated by \
gen-ipmi-fru.pl into a single config file. fru-gen parser \
parses the merged config file and generates cpp file"
PR = "r1"

inherit native
inherit phosphor-ipmi-host
inherit obmc-phosphor-license

DEPENDS += "virtual/phosphor-ipmi-fru-read-inventory"
DEPENDS += "virtual/phosphor-ipmi-fru-read-bmc-inventory"
PROVIDES += "virtual/phosphor-ipmi-fru-merge-config"

do_install_append() {
  SRC=${config_datadir}
  DEST=${D}${config_datadir}
  install -d ${DEST}
  cat ${SRC}/config.yaml ${SRC}/bmc-fru-config.yaml > ${DEST}/fru_config.yaml
}