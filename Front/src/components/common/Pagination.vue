<template>
  <div class="row">
    <div class="col-xxl-12">
        <div class="basic-pagination mt-30">
        <ul class="d-flex align-items-center"> 
            <li class="prev">
                <router-link to="/courses" class="link-btn link-prev">
                    Prev
                    <i class="arrow_left"></i>
                    <i class="arrow_left"></i>
                </router-link>
            </li>
            <li>
                <router-link to="/courses">
                    <span>1</span>
                </router-link>
            </li>
            <li class="active">
                <router-link to="/courses">
                    <span>2</span>
                </router-link>
            </li>
            <li>
                <router-link to="/courses">
                    <span>3</span>
                </router-link>
            </li>
            <li class="next">
                <router-link to="/courses" class="link-btn">
                    Next
                    <i class="arrow_right"></i>
                    <i class="arrow_right"></i>
                </router-link>
            </li>
        </ul>
        </div>
    </div>
</div>
</template>

<script>
export default {
    name:'PaginationArea'
}
</script>

