Ext.define('gantang.mstdata.version.versionModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'installedrank',
			type : 'number'
		},{
		name : 'version',
			type : 'string'
		},{
		name : 'description',
			type : 'string'
		},{
		name : 'type',
			type : 'string'
		},{
		name : 'script',
			type : 'string'
		},{
		name : 'checksum',
			type : 'number'
		},{
		name : 'installedby',
			type : 'string'
		},{
		name : 'installedon',
			type : '${property.jsType}'
		},{
		name : 'executiontime',
			type : 'number'
		},{
		name : 'success',
			type : 'number'
		},{
	}]
});