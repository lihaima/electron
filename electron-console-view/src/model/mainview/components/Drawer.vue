<template>
  <el-drawer :title="title" :visible.sync="model.isVisible" :direction="direction" :append-to-body="append">
                <el-form :rules="model.rules" :model="model.formData" :ref="model.refsName"  size="small" label-width="100px" label-position="left" >
                        <div  v-for="(item , index) in model.dataModeBehavior" :key="index"  v-if ="item.__isHide ==false">
                                <div v-if="item.__if ==null">
                                        <el-form-item :label="item.__title" :prop="item.__key" >
                                                <el-input v-model="model.formData[item.__key]" v-if="item.__type === 'input'  " :placeholder="item.__title" maxlength="64"  style="width:62%" />
                                                <el-select v-if="item.__type === 'selects' " v-model="model.formData[item.__key]">
                                                        <el-option v-for="(selectValue , index) in item.__values"  :key="index"  :label="selectValue.label"  :value="selectValue.value"/>
                                                </el-select>
                                        </el-form-item>
                                </div>
                                <div v-if="item.__if !=null">
                                        <el-form-item v-if=" model.formData[item['if']] == model.formData['ifValue']" :label="item.title" :prop="item.key" >
                                                <el-input v-model="model.formData[item.key]" v-if="(item['type'] == null || item.type === 'input') " :placeholder="item.title" maxlength="64"  style="width:62%" />
                                                <el-select v-if="item.type === 'selects' " v-model="model.formData[item.key]">
                                                        <el-option v-for="(selectValue , index) in item.__values"  :key="index"  :label="selectValue.label"  :value="selectValue.value"/>
                                                </el-select>
                                        </el-form-item>
                                </div>
                        </div>
                        <div>
                                  <span  slot="footer">
                                        <el-button type="success" @click="model.request" size="small">确认</el-button>
                                </span>
                        </div>
                </el-form>
              
        </el-drawer>
</template>

<script>
export default {
props:{
    title:{
        type:String,
        required:true
    },
    model:{
        type:Object,
        required:true
    },
    direction:{
    },
      append:{
        //       type:Boolean,
              
      }
}
}
</script>

<style>

</style>