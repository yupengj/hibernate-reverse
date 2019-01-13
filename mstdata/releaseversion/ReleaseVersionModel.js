Ext.define('gantang.mstdata.releaseversion.ReleaseVersionModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'recTypeId',
			type : 'number'
		},{
		name : 'recId',
			type : 'number'
		},{
		name : 'type',
			type : 'string'
		},{
		name : 'name',
			type : 'string'
		},{
		name : 'description',
			type : 'string'
		},{
		name : 'changeId',
			type : 'number'
		},{
		name : 'releaseVersionExtId',
			type : 'number'
		},{
		name : 'versionNo',
			type : 'number'
		},{
		name : 'jsonContent',
			type : '${property.jsType}'
		},{
	}]
});