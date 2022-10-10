<template>
    <el-drawer :title="title" :visible.sync="viewMode.isVisible" :direction="direction" :size="size">
                <el-row>
                        <el-col :span="8">
                                <div class="filter-input">
                                        <div v-for="(item , index) in viewMode.dataModeBehavior" :key="index">
                                                <div class="filter-input" >
                                                        <span>{{item.__title}}：{{viewMode.formData[item.__key]}}</span>
                                                </div>
                                        </div>
                                </div>
                        </el-col>
                        <slot name="col"></slot>
                </el-row>
                <slot name="drawer"></slot>
        </el-drawer >
</template>

<script>
export default {
  props:{
      direction:{

      },
      size:{
          type:String,
      },
      mode:{
              type:Object,
              required:true
      },
      title:{
              type:String,
              required:true
      }
  },
  computed:{
          viewMode(){
                  return this.mode
          }
  }
}
</script>

<style>

</style>