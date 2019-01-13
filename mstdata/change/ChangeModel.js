Ext.define('gantang.mstdata.change.ChangeModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'employeeId',
			type : 'number'
		},{
		name : 'changeCode',
			type : 'string'
		},{
		name : 'changeDesc',
			type : 'string'
		},{
		name : 'changePriority',
			type : 'string'
		},{
		name : 'changeReason',
			type : 'string'
		},{
		name : 'isSecurityChange',
			type : 'boolean'
		},{
		name : 'changeType',
			type : 'string'
		},{
		name : 'changeContent',
			type : 'string'
		},{
		name : 'projectCode',
			type : 'string'
		},{
		name : 'projectName',
			type : 'string'
		},{
		name : 'productCode',
			type : 'string'
		},{
		name : 'productName',
			type : 'string'
		},{
		name : 'expectEffectiveFrom',
			type : 'date'
		},{
		name : 'expectEffectiveTo',
			type : 'date'
		},{
		name : 'publishDate',
			type : 'date'
		},{
		name : 'releaseDate',
			type : 'date'
		},{
		name : 'changeStatus',
			type : 'string'
		},{
		name : 'outerChangeStatus',
			type : 'string'
		},{
		name : 'isGeneral',
			type : 'boolean'
		},{
		name : 'preChangeId',
			type : 'number'
		},{
		name : 'plantId',
			type : 'number'
		},{
		name : 'masterChangeId',
			type : 'number'
		},{
		name : 'changeExtId',
			type : 'number'
		},{
		name : 'issueDesc',
			type : 'string'
		},{
		name : 'issueReson',
			type : 'string'
		},{
		name : 'suggestSolution',
			type : 'string'
		},{
		name : 'isMaster',
			type : 'boolean'
		},{
		name : 'discriminator',
			type : 'string'
		},{
		name : 'trackerId',
			type : 'number'
		},{
		name : 'vinCode',
			type : 'string'
		},{
		name : 'realDate',
			type : 'date'
		},{
		name : 'batchNo',
			type : 'string'
		},{
		name : 'isReversal',
			type : 'boolean'
		},{
		name : 'organizationId',
			type : 'string'
		},{
	}]
});