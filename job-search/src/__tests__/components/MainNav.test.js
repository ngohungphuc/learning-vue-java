import { render, screen } from '@testing-library/vue'

import MainNav from '@/components/MainNav.vue'

describe('MainNav', () => {
  it('displays company name', () => {
    render(MainNav, {
      data() {
        return {
          //   company: 'super company',
        }
      },
    })
    const companyName = screen.getByText('Company name')
    expect(companyName).toBeInTheDocument()
  })
})
