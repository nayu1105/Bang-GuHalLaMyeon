<template>
  <section class="events__area pt-115 pb-120 p-relative">
    <div class="events__shape">
      <img class="events-1-shape" src="@/assets/img/events/events-shape.png" alt="" />
    </div>
    <div class="container">
      <div class="row">
        <div class="col-xxl-4 offset-xxl-4">
          <div class="section__title-wrapper mb-60 text-center">
            <h2 class="section__title">
              <span class="yellow-bg yellow-bg-big"
                >공지사항<img src="@/assets/img/shape/yellow-bg.png" alt=""
              /></span>
            </h2>
          </div>
        </div>
      </div>
      <div class="row">
        <div
          v-for="board in BoardData"
          :key="board.id"
          class="col-xxl-10 offset-xxl-1 col-xl-10 offset-xl-1 col-lg-10 offset-lg-1"
        >
          <div class="events__item mb-10 hover__active">
            <div
              class="events__item-inner d-sm-flex align-items-center justify-content-between white-bg"
            >
              <div class="events__content">
                <div class="events__meta">
                  <span>{{ board.date }}</span>
                  <span>{{ board.time }}</span>
                  <span>{{ board.city }}</span>
                </div>
                <h3 class="events__title">
                  <router-link to="/boards-details">{{ board.title }}</router-link>
                </h3>
              </div>
              <div class="events__more">
                <router-link to="/boards-details" class="link-btn">
                  View More
                  <i class="far fa-arrow-right"></i>
                  <i class="far fa-arrow-right"></i>
                </router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: 'BoardArea',
  data() {
    return {
      BoardData: [
        {
          id: 1,
          title: 'Digital transformation conference',
          date: 'Jun 14, 2022',
          time: '12:00 am - 2:30 pm',
          city: 'New York',
        },
        {
          id: 2,
          title: 'World education day conference',
          date: 'April 10, 2022',
          time: '9:00 am - 5:00 pm',
          city: 'Mindahan',
        },
        {
          id: 3,
          title: 'Foundations of global health',
          date: 'July 16, 2022',
          time: '10:30 am - 1:30 pm',
          city: 'Weedpatch',
        },
        {
          id: 4,
          title: 'Business creativity workshops',
          date: 'March 24, 2022',
          time: '10:30 am - 12:00 pm',
          city: 'Lnland',
        },
      ],
    };
  },
};
</script>
